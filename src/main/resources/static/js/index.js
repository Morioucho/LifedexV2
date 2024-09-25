document.addEventListener('DOMContentLoaded', () => {
    const searchForm = document.getElementById('search-form');
    const queryInput = document.getElementById('query');
    const searchResults = document.getElementById('search-results');
  
    searchForm.addEventListener('submit', (event) => {
      event.preventDefault();
      const query = queryInput.value.trim();
  
      if (query) {
        fetch(`/search?prefix=${encodeURIComponent(query)}`)
          .then(response => {
            if (!response.ok) {
              throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
          })
          .then(data => {
            searchResults.innerHTML = '';
  
            if (data.length > 0) {
              data.forEach(postTitle => {
                const postElement = document.createElement('div');
                postElement.classList.add('post');
                postElement.innerHTML = `<p>${postTitle}</p>`;
                searchResults.appendChild(postElement);
              });
            } else {
              searchResults.innerHTML = '<p>No posts found</p>';
            }
          })
          .catch(error => console.error('Error fetching search results:', error));
      }
    });
  });