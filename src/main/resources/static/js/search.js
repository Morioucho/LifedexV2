document.addEventListener("DOMContentLoaded", () => {
  const searchForm = document.getElementById("search-form");
  const query = document.getElementById("query");
  const searchResults = document.getElementById("search-results");

  searchForm.addEventListener("submit", async (event) => {
    event.preventDefault(); // Prevent the default form submission
    const queryInput = query.value; // Get the current value from the input

    await queryFind(queryInput); // Pass the input to the function
  });

  async function queryFind(queryInput) {
    try {
      const results = await fetch(`/api/posts/search?query=${encodeURIComponent(queryInput)}`, {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      });
      const queryResults = await results.json();
      console.log(queryResults);
      // You can update the searchResults element with the results here
    } catch (error) {
      console.log("Error fetching article data:", error);
    }
  }
  function renderArticleInfo(article, elementId) {
    const articleInfoHtml = `
      ${article.title}<br>
      ${article.image}<br>
      ${article.description}<br>
      ${article.author}<br>
      ${article.date}<br>
    `;
  }
  searchResults.innerHTML = articleInfoHtml;
  renderArticleInfo(queryResults);
});


  /*
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
  */

