document.addEventListener("DOMContentLoaded", function () {
    class Recipe {
      constructor(
        title,
        image,
        description,
        cookTime,
        author,
        date
      ) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.cookTime = cookTime;
        this.author = author;
        this.date = date;
      }
  
      getTitle() {
        return this.title;
      }
      setTitle(title) {
        this.title = title;
      }
  
      getImage() {
        return this.image;
      }
      setImage(image) {
        this.image = image;
      }
  
      getDescription() {
        return this.description;
      }
      setDescription(description) {
        this.description = description;
      }
  
      getCookTime() {
        return this.cookTime;
      }
      setCookTime(cookTime) {
        this.cookTime = cookTime;
      }

      getAuthor() {
        return this.author;
      }
      setAuthor(author) {
        this.author = author;
      }
  
      getDate() {
        return this.date;
      }
      setDate(date) {
        this.date = date;
      }
    }
  
    function renderArticleInfo(article, elementId) {
      const articleInfoHtml = `
        ${article.title}<br>
        ${article.image}<br>
        ${article.description}<br>
        ${article.cookTime}<br>
        ${article.author}<br>
        ${article.date}<br>
      `;
      
      document.getElementById(elementId).innerHTML = articleInfoHtml;
    }
  
    async function articleDataFetch() {
      try {
        const response = await fetch("/api/posts", {
          method: "GET",
          headers: { "Content-Type": "application/json" },
        });
        const articleInfo = await response.json();
  
        for (var i = 0; i < articleInfo.length; i++) {
          renderArticleInfo(articleInfo[i]);
        }
  
      } catch (error) {
        console.error("Error fetching article data:", error);
      }
    }
    articleDataFetch();
  });
  