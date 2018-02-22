<#assign cc=JspTaglibs["/WEB-INF/counter.tld"]>
<#assign text="gfsdjklgf">

<html>
<body>

<h1>Hello ${user!"Vasya"}!</h1>

This is <@cc.counter /> times of entering this page!
${ 2 + 2 }


<#if foo>
  Do this
</#if>

<#if x == 1>
  Do this
<#else>
  Do that
</#if>

Bar: ${bar?trim}

<p>These are our employees:
<ul>
    <#list persons as person>
        <li>${person.name}</li>
    </#list>
</ul>
</body>
</html>