var count = 0;
var countElement = document.querySelector("#count")

function counter(element) {
    count++;
    countElement.innerText = count + " Like(s)" ;
}

