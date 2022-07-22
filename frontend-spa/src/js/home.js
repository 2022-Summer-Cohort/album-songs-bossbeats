export default function home(albums){
    return `
    <main>
        <div class="main-container">
            <section>
                ${albums.map(album => {
                    return `
                    <div class="album-home">
                        <img src="${album.imgUrl}" alt="album cover">
                        <h2 class="album-name">${album.albumName}</h2>
                        <input type="hidden" class="id-field" value="${album.id}">
                        <p class="artist-name">${album.artistName}</p>
                        <input type="text" class="change-album-name" placeholder="New Album Name">
                        <button class = "change-album-name-button">Change Album Name</button>
                        <button class = "delete-button">Delete Album</button>
                    </div>
                    `
                }).join("")
            };

            </section>
        </div>
</main>
    `
}