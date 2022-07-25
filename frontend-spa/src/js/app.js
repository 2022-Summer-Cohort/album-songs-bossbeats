import header from "./header.js";
import footer from "./footer.js";
import home from "./home.js";
import albumView from "./albumView.js";

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
    // const deleteButton = album.querySelector(".delete-button")
    // deleteButton.addEventListener("click", ()=>{
    //   fetch(`http://localhost:8080/api/albums/${albumIDEl.value}`, {
    //     method: 'DELETE'
    //   })
    //   .then(res=> res.json())
    //   .then(newAlbums => {
    //     makeHomeViewFromJSON(newAlbums);
    //   })
    // })

    // const updateButton = album.querySelector(".change-album-name-button");
    // updateButton.addEventListener("click", ()=>{
    //   const updateInput = album.querySelector(".change-album-name");
    //   fetch(`http://localhost:8080/api/albums/${albumIDEl.value}`, {
    //     method: 'PATCH',
    //     body: updateInput.value
    //   })
    //   .then(res => res.json())
    //   .then(newAlbums => {
    //     makeHomeViewFromJSON(newAlbums);
    //   })
    // })
  });
}

function makeAlbumView(album) {
  console.log(album);
  container.innerHTML = header();
  container.innerHTML += albumView(album);
  container.innerHTML += footer();

  // const backButtonEl = document.querySelector(".back-button");
  // backButtonEl.addEventListener("click", ()=>{
  //   makeHomeView();
  // })
  // let x = container.querySelector(".album-name");
  // x.innerHTML = album.albumName;

  // const songIdEl = document.querySelectorAll(".id-field");
  const songEls = document.querySelectorAll(".song-list");
  // songEl.addEventListener("click",()=>{
  //   alert("Alert!");
  // })
  songEls.forEach((songEl) => {
    let songInfo = songEl.querySelector(".id-field");
    songEl.addEventListener("click", () => {
      const updateTitleButton = songEl.querySelector(
        ".change-song-title-button"
      );
      updateTitleButton.addEventListener("click", () => {
        const updateSong = songEl.querySelector("#change-song-title");
        // console.log(updateSong)
        fetch(
          `http://localhost:8080/api/songs/${songInfo.value}/changeSongName`,
          {
            method: "PATCH",
            body: updateSong.value,
          }
        )
          .then((res) => res.json())
          .then((album) => {
            makeAlbumView(album);
          });
      });
    });
  });

  // const newSongTitle = container.querySelector(".addsong");
  // const addSongButton = container.querySelector(".add-song-button");

  // addSongButton.addEventListener("click", () => {
  //   const newSongJson = {
  //     "title": newSongTitle.value,
  //   }
  //   fetch(`http://localhost:8080/api/albums/${album.id}/addSong`, {
  //     method: 'POST',
  //     headers: {
  //       'Content-type': 'application/json'
  //     },
  //     body: JSON.stringify(newSongJson)
  //   })
  //   .then(res => res.json())
  //   .then(album => {
  //     makeAlbumView(album);
  //   })
  // } )
}

makeHomeView();
