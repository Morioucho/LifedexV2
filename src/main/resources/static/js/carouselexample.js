    const track = document.querySelector('.carousel__track'); //Variable to carousel track.
    const slides = Array.from(track.children);
    const nextButton = document.querySelector('.carousel__button--right');
    const prevButton = document.querySelector('.carousel__button--left');
    const dotsNav = document.querySelector('.carousel__nav');
    const dots = Array.from(dotsNav.children);

    const slideWidth = slides[0].getBoundingClientRect().width;
    // Width set.

    //Slides need to be arranged.
    // I need to set a slide array to move from. Make sure the CSS is set to overflow.

    const setSlidePosition = (slide, index) => {
        slide.style.left = slideWidth * index + 'px';
    };
    slides.forEach(setSlidePosition);
    //The slide buttons have to move the images around.
   
    nextButton.addEventListener("click", e => {
        const currentSlide = track.querySelector('.current-slide');
        const nextSlide = currentSlide.nextElementSibling;
        const amountToMove = nextSlide.style.left;
        track.style.transform = 'translateX(-' + amountToMove + ')';
        currentSlide.classList.remove('current-slide');
        nextSlide.classList.add('current-slide');
    });
    // The dots have to change to match the slide index.
    // The slide buttons have to be removed when the end of the index is hit.