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
      const resultsPost = await fetch(`/api/posts/search?query=${encodeURIComponent(queryInput)}`, {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      });
      const queryResultsPost = await resultsPost.json();
      console.log(queryResultsPost);
      
      const resultsRecipes = await fetch(`/api/recipes/search?query=${encodeURIComponent(queryInput)}`, {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      });
      const queryResultsRecipes = await resultsRecipes.json();
      console.log(queryResultsRecipes);
      
      // Clear previous results
      searchResults.innerHTML = ''
      
      if (queryResultsPost.length > 0) {
        searchResults.innerHTML += '<h2>Posts</h2>';
        queryResultsPost.forEach(article => {
          renderPostInfo(article);
        });
      }
      
      if (queryResultsRecipes.length > 0) {
        searchResults.innerHTML += '<h2>Recipes</h2>';
        queryResultsRecipes.forEach(article => {
          renderRecipeInfo(article);
        });
      }

    } catch (error) {
      console.log("Error fetching article data:", error);
    }
  }

  function renderPostInfo(article) {
    const articleInfoHtml = `
      <a href="http://localhost:8080/posts/${article.id}" id="article-title">${article.title}</a> by 
      ${article.authorFirst} 
      ${article.authorLast} <br>
      Last Modified ${article.lastModified}<br>
    `;
  
    // Append the article info to the searchResults element
    searchResults.innerHTML += articleInfoHtml; // Use += to add to existing content
  }

  function renderRecipeInfo(article) {
    const articleInfoHtml = `
      <a href="http://localhost:8080/recipes/${article.id}" id="article-title">${article.title}</a> by 
      ${article.authorFirst} 
      ${article.authorLast} <br>
      Last Modified ${article.lastModified}<br>
    `;
  
    // Append the article info to the searchResults element
    searchResults.innerHTML += articleInfoHtml; // Use += to add to existing content
  }
});