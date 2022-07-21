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
                <ul class="song-list">
                ${album.songs.map(song => {
                    return `
                        <li class="song"><a href=".">${song.title}</a></li>
                        <input type="hidden" class="id-field" value="${song.id}">


                        `;
                  })
                  .join("")}
                </ul>
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
