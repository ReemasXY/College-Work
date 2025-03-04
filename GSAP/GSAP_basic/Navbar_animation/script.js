let tl = gsap.timeline();

tl.from(".logo", {
  y: 20,
  opacity: 0,
  duration: 0.5,
  delay: 0.3,
});

tl.from("nav ul li", {
  y: 20,
  opacity: 0,
  delay: 0.3,
  stagger: 0.2,
});

tl.from(".content", {
  scale: 0.4,
  opacity: 0,
});
