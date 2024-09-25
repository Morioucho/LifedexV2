document.addEventListener("DOMContentLoaded", () => {
  const searchForm = document.getElementById("search-form");
  const queryInput = document.getElementById("query");
  const searchResults = document.getElementById("search-results");

  searchForm.addEventListener("submit", (event) => {
    event.preventDefault();
    const query = queryInput.value;

    fetch(`/api/search?query=${encodeURIComponent(query)}`)
      .then((response) => response.json())
      .then((data) => {
        searchResults.innerHTML = "";

        if (data.length > 0) {
          data.forEach((post) => {
            const postElement = document.createElement("div");
            
            postElement.classList.add("post");
            postElement.innerHTML = `
                <h2>${post.title}</h2>
                <p>${post.content}</p>
              `;
            searchResults.appendChild(postElement);
          });
        } else {
          searchResults.innerHTML = "<p>No posts found</p>";
        }
      })
      .catch((error) => console.error("Error fetching search results:", error));
  });
});
