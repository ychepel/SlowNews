window.onload = function() {
    var req = new XMLHttpRequest();
    req.open('GET', 'weather', true);
    req.onreadystatechange = function (aEvt) {
        if (req.readyState == 4) {
            if(req.status == 200)
                document.getElementById("weather").innerHTML=req.responseText;
            else
                console.log("Error loading weather\n");
        }
    };
    req.send(null);
};