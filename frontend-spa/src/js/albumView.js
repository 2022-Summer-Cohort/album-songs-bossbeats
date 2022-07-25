export default function albumView(album) {
  return `
    <main>
    <div class="main-container">
        <section>
            <div class="album">
                <img src="${album.imgUrl}" alt="album cover">
                <h2 class="album-name">${album.albumName}</h2>
                <p class="artist-name">${album.artistName}</p>
                <p class="label">${album.recordLabel}</p>
                <input class="id" type="hidden" value="${album.id}">
                <ul>
                ${album.songs.map(song => {
                    return `
                        <div class = "song-list">
                            <li class="song"><a href=".">${song.title}</a></li>
                            <input type="hidden" class="id-field" value="${song.id}">
                            
                            <input type="text" id="change-song-title" placeholder="New Song Title">
                            <button class="change-song-title-button">Change Song Title</button>
                            <img class="delete-song-button" src="/frontend-spa/src/Images/delete-song-interface-symbol-svgrepo-com.svg" alt="delete song">
    
                        </div>
                        `;
                  })
                  .join("")}
                </ul>
                <br>
                <br>
                <div class="edit-album">
                <input type="text" class="change-album-name" placeholder="New Album Name">
                <button class = "change-album-name-button">Change Album Name</button>
                <button class = "delete-button">Delete Album</button>
                <input type="text" class="add-song" placeholder="Add New Song Here">
                <button class="add-song-button">Add Song</button>
                </div>
                <div class="rating-comment">
                   

                    <ul class="comment-list">
                    ${album.comments.map(comment=> {
                        return `
                            <li class="comment">${comment}</li>
                        `
                    }).join("")
                }
                       
                    </ul> 
                    <p class="rating-average">Average 0 out of 5</p>
                    <textarea name="comment" id="comment" cols="30" rows="10" placeholder="Add comment here."></textarea>
                    <br>
                    <button class="submit-comment">Submit</button>
                </div>
            </div>
        </section>
       

    </div> 
   
</main>




    `;
}
