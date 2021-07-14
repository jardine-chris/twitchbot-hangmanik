document.getElementById("menu-button").addEventListener("click",
    () => {
        let links = document.getElementById("links");
        if (links.style.display === "block") {
            links.style.display = "none";
        } else {
            links.style.display = "block";
        }
    });

