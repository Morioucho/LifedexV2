document.addEventListener("DOMContentLoaded", () => {
    const track = document.getElementsByClassName('carousel__track'); //Variable to carousel track.
    const slides = Array.from(track.children);
    const rightButton = document.getElementsByClassName('carousel__button--right');
    const leftButton = document.getElementsByClassName('carousel__button--left');
    const dotNav = document.getElementsByClassName('carousel__nav');
    const dot = Array.from(dotNav.children);

    const slideWidth = slides[0].getBoundingClientRect().width;
    // Width set.

    //Slides need to be arranged.
    // I need to set a slide array to move from. Make sure the CSS is set to overflow.

    const slidePosition = (index) => {
        for (var index = 0; index < slides.length; index++) {
        slides[index].style.left = slideWidth * index + "px"
    }};
    //The slide buttons have to move the images around.
    rightButton.addEventListener("click", e => {
        const currentSlide = track.getElementsByClassName('current-Slide');
        const nextSlide = currentSlide.nextElementSibling;
        const moveDistance = nextSlide.style.left;

        track.style.transform = 'translateX(-' + moveDistance + ')';
    })
    // The dots have to change to match the slide index.
    // The slide buttons have to be removed when the end of the index is hit.
})