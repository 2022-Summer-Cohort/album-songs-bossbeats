export default function songView(song){
    return `
    <main>
    <div class="main-container">
        <section>
            <div class="song-view">
                <img src="" alt="/">
                <h2 class="song-name">${song.title}</h2>
                <p class="album-name">${song.album}</p>
                <a href="/" class="song-link">Link to song</a>
                <p class="duration">${song.duration}</p>
                <input type="text" id="change-song-title" placeholder="New Song Title">
                <button class="change-song-title-button">Change Song Title</button>
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
    `
}