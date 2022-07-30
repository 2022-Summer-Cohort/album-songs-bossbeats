import header from "./header.js";
import footer from "./footer.js";
import home from "./home.js";
import albumView from "./albumView.js";
import backButton from "./backToAllAlbumsButton.js";
import songView from "./songview.js";
import backToSingleAlbumButton from "./backToSingleAlbumButton.js";

const container = document.querySelector(".container");

// function makeHomeView() {
//   fetch("http://localhost:8080/api/albums")
//     .then((res) => res.json())
//     .then((albums) => {
//       console.log(albums);
//       container.innerHTML = header();
//       container.innerHTML += home(albums);
//       container.innerHTML += footer();

//       const albumsEl = document.querySelectorAll(".album-home");

//       albumsEl.forEach((album) => {
//         album.addEventListener("click", () => {
//           let albumId = album.querySelector(".id-field");
//           makeAlbumView(albumId.value);
//         });
//       });
//     });
// }

function makeHomeView() {
  fetch("http://localhost:8080/api/albums")
    .then((res) => res.json())
    .then((albums) => {
      makeHomeViewFromJSON(albums);
    });
}
function makeHomeViewFromJSON(albums) {
  console.log(albums);
  container.innerHTML = header();
  container.innerHTML += home(albums);
  container.innerHTML += footer();

  const albumEL = container.querySelectorAll(".album-home");

  albumEL.forEach((album) => {
    let albumIDEl = album.querySelector(".id-field");

    const albumCoverEl = album.querySelector(".album-cover");
    albumCoverEl.addEventListener("click", () => {
      fetch(`http://localhost:8080/api/albums/${albumIDEl.value}`)
        .then((res) => res.json())
        .then((albumJson) => {
          makeAlbumView(albumJson);
        });
    });


  });
}

function makeAlbumView(album) {
  console.log(album);
  container.innerHTML = header();
  container.innerHTML += backButton();
  container.innerHTML += albumView(album);
  container.innerHTML += footer();

  const backButtonEl = document.querySelector(".back-button");
  backButtonEl.addEventListener("click", ()=>{
    makeHomeView();
  })

  const songEl = container.querySelectorAll(".song");
  songEl.forEach((song)=>{
    let songIdEl = song.querySelector(".id-field");
    const songTitleEl = song.querySelector(".song-title");
    songTitleEl.addEventListener("click", ()=>{
    fetch(`http://localhost:8080/api/songs/${songIdEl.value}`)
    .then(res => res.json())
    .then(song => {
      makeSongView(song, album.id);
    })
  })
  const deleteButton = song.querySelector(".delete-song-button");
  deleteButton.addEventListener("click", ()=> {
    fetch(`http://localhost:8080/api/songs/${songIdEl.value}`, 
  {
    method: 'DELETE'
  }
  )
  .then(res => res.json())
  .then(album => {
    makeAlbumView(album);
  })
})
})


    const albumIdEl = document.querySelector(".id");
    const deleteAlbumButton = document.querySelector(".delete-button")
    deleteAlbumButton.addEventListener("click", ()=>{
      fetch(`http://localhost:8080/api/albums/${albumIdEl.value}`, {
        method: 'DELETE'
      })
      .then(res=> res.json())
      .then(newAlbums => {
        makeHomeViewFromJSON(newAlbums);
      })
    })


    const updateButton = document.querySelector(".change-album-name-button");
    updateButton.addEventListener("click", ()=>{
      const updateInput = document.querySelector(".change-album-name");
      fetch(`http://localhost:8080/api/albums/${albumIdEl.value}`, {
        method: 'PATCH',
        body: updateInput.value
      })
      .then(res => res.json())
      .then(newAlbums => {
        makeHomeViewFromJSON(newAlbums);
      })
    })

   
  


  const newSongTitle = document.querySelector(".add-song");
  const addSongButton = document.querySelector(".add-song-button");

  addSongButton.addEventListener("click", () => {
    const newSongJson = {
      "title": newSongTitle.value,
    }
    fetch(`http://localhost:8080/api/albums/${albumIdEl.value}/addSong`, {
      method: 'POST',
      headers: {
        'Content-type': 'application/json'
      },
      body: newSongJson.title
    })
    .then(res => res.json())
    .then(album => {
      makeAlbumView(album);
    })
  } )

  const addCommentText = document.querySelector("#comment");
  const addRatingInteger = document.querySelector("#int-rating")
  const submitCommentButton = document.querySelector(".submit-comment");
  submitCommentButton.addEventListener("click", () => {
    const newComment = {
      "comment": addCommentText.value,
      
    }
    const newRating = {
      "rating": addRatingInteger.value,
    }
    if(addCommentText.value == ""){
      alert("Please enter a comment.");
    }else{
    fetch(`http://localhost:8080/api/albums/${albumIdEl.value}/addComment`, {
      method: 'POST',
      headers: {
        'Content-type': 'application/json'
      },
      body: newComment.comment
    })
    .then(res => res.json())
    .then(album=>{
      makeAlbumView(album);
    })
    .then( fetch(`http://localhost:8080/api/albums/${albumIdEl.value}/addRating`, {
      method: 'POST',
      headers: {
          'Content-type' : 'application/json'        
      },
      body: newRating.rating
    })
    .then(res => res.json())
    .then(album => {
      makeAlbumView(album);
    }))
  }
  })

  
}

function makeSongView(song, albumId){
  container.innerHTML = header();
  container.innerHTML += backToSingleAlbumButton();
  container.innerHTML += songView(song, albumId);
  container.innerHTML += footer();
  let songIdEl = document.querySelector(".song-id");
  
  const backButtonEl = document.querySelector(".back-to-album-button");
  backButtonEl.addEventListener("click", ()=>{
    let albumIdEl = document.querySelector(".album-id");
    fetch(
      `http://localhost:8080/api/albums/${albumId}`,)
    .then(res => res.json())
    .then((album)=>{
      makeAlbumView(album);
    })
  })

  const changeSongTitleButton = document.querySelector(".change-song-title-button");
  changeSongTitleButton.addEventListener("click", ()=>{
    const updateSong = document.querySelector("#change-song-title");
    fetch(
      `http://localhost:8080/api/songs/${songIdEl.value}/changeSongName`,
      {
        method: "PATCH",
        body: updateSong.value,
      }
    )
      .then((res) => res.json())
      .then((song) => {
        makeSongView(song, albumId);
      });
  });
 
  const addCommentText = document.querySelector("#comment");
  const addRatingInteger = document.querySelector("#int-rating")
  const submitCommentButton = document.querySelector(".submit-comment");
  submitCommentButton.addEventListener("click", () => {
    const newComment = {
      "comment": addCommentText.value,
      
    }
    const newRating = {
      "rating": addRatingInteger.value,
    }
    if(addCommentText.value == ""){
      alert("Please enter a comment.");
    }else{
    fetch(`http://localhost:8080/api/songs/${songIdEl.value}/addComment`, {
      method: 'POST',
      headers: {
        'Content-type': 'application/json'
      },
      body: newComment.comment
    })
    .then(res => res.json())
    .then(song=>{
      makeSongView(song, albumId);
    })
    .then( fetch(`http://localhost:8080/api/songs/${songIdEl.value}/addRating`, {
      method: 'POST',
      headers: {
          'Content-type' : 'application/json'        
      },
      body: newRating.rating
    })
    .then(res => res.json())
    .then(song => {
      makeSongView(song, albumId);
    }))
  }
  })
     

  
  

}
makeHomeView();
