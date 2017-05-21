const url = "http://localhost:3001/api/forecast/";
let $notifier = $("#notifier");
let $forecastConteiner = $('#forecast-conteiner');

$("#btn-forecast").click(() => {
    let town = $('#input-town').val();
    $notifier.html('Getting your forecast!');
    $forecastConteiner.html("");

    if (town.length < 1) {
        $notifier.html("Please choice a town!");

        setTimeout(() => {
            $notifier.html("");
        }, 5000);

        return;
    }


    $.ajax({
        url: url + town
    }).then(res => {
        $notifier.html("");

        $forecastConteiner.append(`<h3>Town: ${res.location.name}</h3>`);
        $forecastConteiner.append(`<div>Country: ${res.location.country}</div>`);

        $forecastConteiner.append(`<div>Celsius: ${res.current.temp_c}</div>`);
        $forecastConteiner.append(`<div>Condition: ${res.current.condition.text}</div>`);

        $forecastConteiner.append(`<img src="${res.current.condition.icon.trimLeft('/')}" class="img-thumbnail"/>`);


        $forecastConteiner.append(`<div>Wind: ${res.current.wind_kph}</div>`);
    })
})
