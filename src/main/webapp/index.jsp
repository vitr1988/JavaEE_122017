<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>JSON Example</title>
    <link rel="stylesheet" href='<%= request.getContextPath() %>/css/style.css'/>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.min.js" type="text/javascript"></script>
    <script src="<%= request.getContextPath() %>/js/promise.js" type="text/javascript"></script>
    <script src="<%= request.getContextPath() %>/js/closure.js" type="text/javascript"></script>
    <script>
        $(function() {
            var data = {mark : 'Lada', model : 'XRAY'};
            $('#plane1').html(data.mark + ' ' + data.model);

            $.getJSON( "gson", function( data ) {
                $('#plane2').html(data.mark + ' ' + data.model);
            });

            var scriptElement = document.getElementById('scriptText');
            scriptElement.addEventListener('blur', function(){
                <%--makeRequest('GET', '<%= request.getContextPath() %>/js?text=' + scriptElement.value,
                    function (err, datums) {
                        if (err) { throw err; }
                        $('#nashornResult').val(datums);
                    });
                --%>

                makeRequestWithPromise('GET', '<%= request.getContextPath() %>/js?text=' + scriptElement.value)
                    .then(function (datums) {
                        $('#nashornResult').val(datums);
                    })
                    .catch(function (err) {
                        console.error('Augh, there was an error!', err.statusText);
                    });
            });
        });
    </script>
</head>

<body>
<h2>Hello World!</h2>
<div id="plane1"></div>
<div id="plane2"></div>
<div>
    <label for="scriptText" class="firstColumnWidth">Скрипт для запуска:</label>
    <input type="text" id="scriptText" class="inputWidth"/>
</div>
<div>
    <label for="nashornResult" class="firstColumnWidth">Результат:</label>
    <textarea id="nashornResult" class="inputWidth" disabled></textarea>
</div>


</body>
</html>
