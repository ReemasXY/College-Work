gsap.to("#box", {
  // .to is used to move the object from initial point to the final point
  // or say used to apply the changes in the object
  x: 100, // move the box 100 px to the right

  duration: 2, // total time of animation i.e 2 sec

  delay: 1, // it means when the animation will start

  //css can also be written but in camelCase
  backgroundColor: "blue", // changes the background color to blue once the animation in ended (not at once but will be changed slowly as animation takes placce)
  borderRadius: "300px",
});

gsap.from(".box2", {
  //.from is used to move the object from final point to the initial point
  //or say the following properties will be applied first and then all will become normal

  // x and y are translate X and Translate Y of css(move the objects leftright or top bottom)
  x: 1000, //paila 1000px x axis ma hunxa ani animation sakesi afno thau ma auxa
  duration: 2,
  rotate: 360,
  delay: 1,

  // for repeating animation we use repeat
  repeat: 1, //2 choti chalxa animation kina bhane 1 choti ta default nai chalxa so extra 1 times chalza
  // in other words (repeat value + 1 times chalxa total animation)

  repeat: -1, // infinite chalxa animation

  yoyo: true, // .from lai .to ma change hanxa once 1st animation is complete
  // yoyo repeat bho bhane matra kam garxa
});

// animation for the multiple elements having same class,tags or ids
gsap.from("h1", {
  //selects all the h1 tags

  opacity: 0, //first opacity 0 and last ma 1 hunxa
  y: 20,
  duration: 2,
  delay: 5, // (animation suru hune kati time paxi  )

  // Inorder to run the animation for each of the h1 here we use stagger
  stagger: 1, // this runs the animation for each of the h1 tags separately ani 1 sec ko diff ma sab tags show hunxa

  stagger: -0.5, //ulto chalaidinxa teti matra ho( last h1 paila show hunxa ani first ko h1 last ma show hunxa)
});

//Gsap Timelines
// to use the animation one after another we use timelines( meaning 1 ta animation sakepaxi arko suru garna lai chaixa)
// by default sab animation same time ma chalxa
// by default asynchronous xan animation chalne teslai synchronous garna ni yo chaixa
let tl = gsap.timeline();
// tl.to(("box"),{})// this will run first
// tl.to(("box"),{})// after the first one this will run second
// tl.to(("box"),{})// and lastly this will run after the second animation is completed
