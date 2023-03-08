<html>
<head>
    <title>Welcome!</title>
</head>
<script>
    function httpGet(theUrl) {
        console.time("httpGetTotal")
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.open("GET", theUrl, true); // false for synchronous request

        // via Cache-Control header:
        xmlHttp.setRequestHeader("Cache-Control", "no-cache, no-store, max-age=0");
        // fallbacks for IE and older browsers:
        xmlHttp.setRequestHeader("Expires", "Tue, 01 Jan 1980 1:00:00 GMT");
        xmlHttp.setRequestHeader("Pragma", "no-cache"); //Edit: I noticed this is required for Chrome some time ago... forgot to mention here

        xmlHttp.onload = (event) => {
            console.timeEnd("httpGetLoadResponse")
            console.time("httpGetParseOverhead")
            const res = xmlHttp.response; // Note: not req.responseText
            if (res) {
                JSON.parse(res)
                console.time("httpGetDecodeJson")

                console.timeEnd("httpGetDecodeJson")
            }

            console.timeEnd("httpGetParseOverhead")
            console.timeEnd("httpGetTotal")
        };

        console.time("httpGetLoadResponse")
        xmlHttp.send(null);
    }

    httpGet("/states");

</script>
<body>
<h1>Welcome2 ${model}!</h1>
</body>
</html>