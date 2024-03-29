export default function albumView(album) {
  return `
  <main>
  <div class="main-container-album">
          <div class="album">
              <div class="album-img">
              <img src="${album.imgUrl}" alt="album cover">
              <div class="album-info">
              <h2 class="album-name">${album.albumName}</h2>
              <p class="artist-name">${album.artistName}</p>
              <p class="label">${album.recordLabel}</p>
              <input class="id" type="hidden" value="${album.id}">
              
              <div class="edit-album">
              <div class="change-btn">
                  <input type="text" class="change-album-name" placeholder="New Album Name">
                  <br>
                  <button class = "change-album-name-button">Change Album Name</button>
                  <br>
                  <button class = "delete-button">Delete Album</button>
                  </div>
                  </div>
          </div>
                  </div>
          </div>
          <div class="songs">
              <ul>
              <h2>Track List</h2>
              <div class="song-lists">
              ${album.songs
                .map((song) => {
                  return `
                      <div class = "song">

                       
                          
                          <li class="song-title"> ${song.title}</li>
                          <input type="hidden" class="id-field" value="${song.id}">
                        <svg class="delete-song-button" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
	 width="489.275px" height="489.275px" viewBox="0 0 489.275 489.275" style="enable-background:new 0 0 489.275 489.275;"
	 xml:space="preserve">
<g>
	<g>
		<path d="M218.421,227.837c-12.698,10.94-27.398,19.606-43.488,25.34v102.649c-7.953-3.185-16.624-4.955-25.713-4.955
			c-38.218,0-69.2,30.981-69.2,69.2s30.982,69.201,69.2,69.201c38.219,0,69.201-30.982,69.201-69.201c0-0.02,0-0.037,0-0.057l0,0
			V227.837L218.421,227.837z"/>
		<path d="M265.328,108.531c0.565,5.046,0.883,10.164,0.883,15.359c0,26.227-7.409,50.756-20.225,71.617H440.69v160.322
			c-7.953-3.185-16.622-4.955-25.712-4.955c-38.218,0-69.201,30.983-69.201,69.2c0,38.219,30.983,69.201,69.201,69.201
			s69.201-30.982,69.201-69.201c0-0.02-0.003-0.037-0.003-0.057h0.003v-224.51v-86.976H440.69H265.328z"/>
		<path d="M128.986,247.781c16.24,0,31.735-3.158,45.948-8.838c16.562-6.62,31.351-16.707,43.488-29.37
			c4.209-4.392,8.095-9.092,11.625-14.066c14.359-20.224,22.83-44.925,22.83-71.617c0-5.203-0.357-10.321-0.981-15.359
			C244.327,47.361,192.206,0,128.987,0C60.564,0,5.096,55.468,5.096,123.89C5.095,192.313,60.561,247.781,128.986,247.781z
			 M51.959,95.687h154.049v12.847v43.561h-31.076H51.959V95.687z"/>
	</g>
</g>
<g>
</g>
<g>
</g>
<g>
</g>
<g>
</g>
<g>
</g>
<g>
</g>
<g>
</g>
<g>
</g>
<g>
</g>
<g>
</g>
<g>
</g>
<g>
</g>
<g>
</g>
<g>
</g>
<g>
</g>
</svg>

                      </div>
                      `;
                })
                .join("")}
                </div>
              </ul>
              <br>
              <br>
              <div class="add-song-container">
              
              <input type="text" class="add-song" placeholder="New Song">
              <button class="add-song-button">Add song</button>
              </div>
            </div>
          </div>

</div>
  </div> 
              <div class="rating-comment">
                 

                  <ul class="comment-list">
                  ${album.comments
                    .map((comment) => {
                      return `
                          <li class="comment">${comment}</li>
                      `;
                    })
                    .join("")}
                  </ul> 
                  <div class="rating">
             
                  <p class="rating-average">Average ⭐ ${
                    album.avgRating
                  } out of 5</p>
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
             
     

 
 
</main>




    `;
}
