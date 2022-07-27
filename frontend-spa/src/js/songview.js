export default function songView(song){
    return `
    <main>
    <div class="main-container">
        <section>
            <div class="song-view">
                <a href="${song.link}" target="_blank"><img src="${song.img}" alt="video still"></a>
                <h2 class="song-name">${song.title}</h2>
                <input class="song-id" type="hidden" value="${song.id}">
                
                <p class="duration">${song.duration}</p>
                <input type="text" id="change-song-title" placeholder="New Song Title">
                <button class="change-song-title-button">Change Song Title</button>
                <div class="rating-comment">
                 

                  <ul class="comment-list">
                  ${song.comments
                    .map((comment) => {
                      return `
                          <li class="comment">${comment}</li>
                      `;
                    })
                    .join("")}
                  </ul> 
                  <div class="rating">
             
                  <p class="rating-average">Average ⭐ ${song.avgRating} out of 5</p>
                  <br>
                  <textarea name="comment" id="comment" cols="30" rows="10" placeholder="Add comment here."></textarea>
                  <br>
                  <label for="int-rating">⭐</label>
                  <input type="number" min="1" max="5" id="int-rating" name="rating" value="1"
                  <br>
                  <br>
                  <button class="submit-comment">Submit</button>
                  </div>
                    
                  
              </div>
            </div>
        </section>
    </div>
</main>
    `
}