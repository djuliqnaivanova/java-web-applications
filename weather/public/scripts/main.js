const url = "http://localhost:3001/api/forecast/";
let $notifier = $("#notifier")

$("#btn-forecast").click(()=>{
    let town = $('#input-town').val();

    if (town.length < 1) {
        $notifier.html("Please choice a town!");

        setTimeout(()=>{
        $notifier.html("");
        }, 5000);

        return;
    }

    let $forecastConteiner = $('#forecast-conteiner')

    $.ajax({
        url:url+town
    }).then(res => {
        $forecastConteiner.append(`<h3>Town: ${res.location.name}</h3>`)
        $forecastConteiner.append(`<div>Country: ${res.location.country}</div>`)

        $forecastConteiner.append(`<div>Celsius: ${res.current.temp_c}</div>`)
        $forecastConteiner.append(`<div>Condition: ${res.current.condition.text}</div>`)
        
        $forecastConteiner.append(`<img src="${res.current.condition.icon.trimLeft('/')}" class="img-thumbnail"/>`)

        
        $forecastConteiner.append(`<div>Wind: ${res.current.wind_kph}</div>`)


    })
})

/**
 * location
 * --name
 * --country
 * current 
 * --temp_c
 * --condition
 * ----text
 * ----icon
 * --wind_kph
 */



