<html>
<head>
<title>JSON Example</title>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.min.js" type="text/javascript"></script>
    <script>
        $(function() {
            var data = {mark : 'Lada', model : 'XRAY'};
            $('#plane1').html(data.mark + ' ' + data.model);

            $.getJSON( "gson", function( data ) {
                $('#plane2').html(data.mark + ' ' + data.model);
            });
        });
    </script>
</head>

<body>
<h2>Hello World!</h2>
<div id="plane1"></div>
<div id="plane2"></div>
</body>
</html>
