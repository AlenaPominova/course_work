$(document).ready(function() {
    var myMap;
    var myPlacemark;
    var object = $("#object");

    var parseData = function(object) {
        // var json = JSON.parse(object);

        // myPlacemark = new ymaps.Placemark([object.latitude, object.longitude], { hintContent: 'Москва!', balloonContent: 'Столица России' });
        //[55.76, 37.64],
        // for (var i = 0; i < object.size() ; i++) {
          //  myPlacemark.add([object.latitude, object.longitude]);
        // }
        //return myPlacemark;
    };
    // var loadParking = function () {
    //     $.ajax({
    //         type: "GET",
    //         url: "/",
    //        // dataType: 'JSON',
    //         cache: false,
    //         success: function (data) {
    //             parseData(data);
    //             console.log("SUCCESS : ", data);
    //         },
    //         error: function (e) {
    //          //   $("#p1").text(e.responseText);
    //             console.log("ERROR : ", e);
    //         }
    //     });
    // };

    function init(){
        myMap = new ymaps.Map("map", {
            center: [55.76, 37.64],
            zoom: 7
        });
        //loadParking();
        myPlacemark = new ymaps.Placemark([object.latitude, object.longitude], { hintContent: 'Москва!', balloonContent: 'Столица России' });
        myMap.geoObjects.add(myPlacemark);
    }

    ymaps.ready(init);
});


