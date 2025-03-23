let rbtn= document.getElementById("rwrite");
let parent= document.getElementsByClassName("parent")[0];
let child= document.getElementsByClassName("child")[0];
let cancel= document.getElementById("cancel");

let result="resources/img/default1.png";
rbtn.addEventListener("click",()=>{
    console.log(child,parent);
    parent.classList.add("padd");
    parent.classList.remove("pz");
  

    child.classList.add("cadd");
})

cancel.addEventListener("click", (e)=>{
    e.preventDefault();
    child.classList.remove("cadd");
    parent.classList.remove("padd");
        setTimeout(()=>{
            parent.classList.add("pz");
        },300);
        
})


child.addEventListener("submit",(e)=>{
    e.preventDefault();
 
    console.log(result);
})
document.getElementById("fileInput").addEventListener("change", function(event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            document.getElementById("preview").src = e.target.result;
           result= e.target.result;
        };
        reader.readAsDataURL(file);
    }
});


