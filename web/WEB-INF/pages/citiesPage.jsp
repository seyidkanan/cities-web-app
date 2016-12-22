<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kanan
  Date: 12/20/2016
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cities</title>


    <link rel="stylesheet" href="../../resources/css/material.min.css" type="text/css">
    <script src="../../resources/js/material.min.js"></script>
    <script src="../../resources/js/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">



    <script type="text/javascript">
        function reload() {
            location.reload();
        }
    </script>

</head>


<body>


<div>

    <div>
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
                onclick="reload()">
            Cities List
        </button>



        <dialog class="mdl-dialog">
            <div class="mdl-dialog__content">
                <p>
                    Allow this site to collect usage data to improve your experience?
                </p>
            </div>
            <div class="mdl-dialog__actions mdl-dialog__actions--full-width">
                <button type="button" class="mdl-button">Agree</button>
                <button type="button" class="mdl-button close">Disagree</button>
            </div>
        </dialog>


    </div>
    <div>
        <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="width: 100%">
            <thead>
            <tr>
                <th class="mdl-data-table__cell--non-numeric">ID</th>
                <th>COUTRY CODE</th>
                <th>STANDART CITY NAME</th>
                <th>REAL CITY NAME</th>
                <th>REGION</th>
                <th>POPULATION</th>
                <th>LATIDUDE</th>
                <th>LONGITUDE</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${cityList}" var="city">
                <tr>
                    <td class="mdl-data-table__cell--non-numeric">${city.id}</td>
                    <td>${city.countryCode}</td>
                    <td>${city.standartCityName}</td>
                    <td>${city.realCity}</td>
                    <td>${city.region}</td>
                    <td>${city.population}</td>
                    <td>${city.latitude}</td>
                    <td>${city.longitude}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>

<%-- <button type="button" class="mdl-button show-modal">Show Modal</button>
  <dialog class="mdl-dialog">
    <div class="mdl-dialog__content">
      <p>
        Allow this site to collect usage data to improve your experience?
      </p>
    </div>
    <div class="mdl-dialog__actions mdl-dialog__actions--full-width">
      <button type="button" class="mdl-button">Agree</button>
      <button type="button" class="mdl-button close">Disagree</button>
    </div>
  </dialog>
  <script>
    var dialog = document.querySelector('dialog');
    var showModalButton = document.querySelector('.show-modal');
    if (! dialog.showModal) {
      dialogPolyfill.registerDialog(dialog);
    }
    showModalButton.addEventListener('click', function() {
      dialog.showModal();
    });
    dialog.querySelector('.close').addEventListener('click', function() {
      dialog.close();
    });
  </script>--%>
