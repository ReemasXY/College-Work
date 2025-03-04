gsap.from(".page1 .box", {
  scale: 0,
  opacity: 0,
  rotate: 720,
  duration: 2,
});
// This will run the animation without even showing it to the user
// gsap.from(".page2 .box", {
//   scale: 0,
//   opacity: 0,
//   rotate: 720,
//   duration: 2,
// });

// we use the scroll triggger when we want to animate something based on scroll
// to do that we use "scrollTrigger"
gsap.from(".page2 .box", {
  scale: 0,
  opacity: 0,
  rotate: 720,
  duration: 2,
  //   scrollTrigger: ".page2 .box", // name of element where scroll animation will trigger ( yo element ma pugesi trigger hunxa)

  // this can also be done if we simply want a animation on scroll

  // this is bit in detail

  scrollTrigger: {
    trigger: ".page2 .box", // it takes name of element where the animation starts
    scroller: "body", // by default yei hunxa body (not explained in detail)
    markers: true, // scroll start end matra dekhauxa for easy view
    start: "top 60%",
  },
});
