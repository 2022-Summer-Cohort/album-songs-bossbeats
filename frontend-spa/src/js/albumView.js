export default function albumView(album) {
  return `
    <main>
    <div class="main-container">
        <section>
            <div class="album">
                <img src="${album.imageUrl}" alt="album cover">
                <h2 class="album-name">${album.albumName}</h2>
                <p class="artist-name">${album.artistName}</p>
                <p class="label">${album.recordLabel}</p>
                <ul>
                ${album.songs.map(song => {
                    return `
                        <div class = "song-list">
                            <li class="song"><a href=".">${song.title}</a></li>
                            <input type="hidden" class="id-field" value="${song.id}">
                            <button class="delete-song-button">Delete Song</button>
                            <input type="text" id="change-song-title" placeholder="New Song Title">
                            <button class="change-song-title-button">Change Song Title</button>
                        </div>
                        `;
                  })
                  .join("")}
                </ul>
                <input type="text" id="add-song" placeholder="Add New Song Here">
                <button class="add-song-button">Add Song</button>
                <div class="rating-comment">
                    <p class="rating-average">Average 0 out of 5</p>
                    <ul class="comment-list">
                        <li class="comment">comment</li>
                    </ul>
                </div>
            </div>
        </section>
    </div>
</main>




    `;
}
