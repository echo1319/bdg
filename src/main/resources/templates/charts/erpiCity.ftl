<script>
    Chart.plugins.register({
        beforeDraw: function (chart) {
            var data = chart.data.datasets[0].data;
            var sum = data.reduce(function (a, b) {
                return a + b;
            }, 0);
            var width = chart.chart.width,
                    height = chart.chart.height,
                    ctx = chart.chart.ctx;
            ctx.restore();
            var fontSize = (height / 10).toFixed(2);
            ctx.font = fontSize + "px Arial";
            ctx.textBaseline = "middle";
            var text = sum,
                    textX = Math.round((width - ctx.measureText(text).width) / 2),
                    textY = height / 2;
            ctx.fillText(text, textX, textY);
            ctx.save();
        }
    });


    var randomScalingFactor = function () {
        return Math.round(Math.random() * 100);
    };

    var fetchErpiData = function () {
        return 48;
    }

    var fetchData = function () {
        $.getJSON('metrics/garden/aqi', function (data) {
            console.log("data are" + data);
            return data.value;
        });
    }

    var config = {
        type: 'doughnut',
        data: {
            labels: ["ERPI", "AQI", "Sound", "Temperature"],
            datasets: [{
                data: [
                    randomScalingFactor(),
                    1 - randomScalingFactor()

                ],
                backgroundColor: [
                    "#F7464A",
                    "#FFFFFF"
                ],
                labels: ['ERPI']
            },
                {
                    data: [
                        randomScalingFactor(),
                        randomScalingFactor()
                    ],
                    backgroundColor: [
                        "#46BFBD",
                        "#FFFFFF"
                    ],
                    labels: ['AQI']
                },
                {
                    data: [
                        randomScalingFactor(),
                        randomScalingFactor()

                    ],
                    backgroundColor: [

                        "#FDB45C",
                        "#FFFFFF"
                    ],
                    labels: ['Sound']
                },

                {
                    data: [
                        randomScalingFactor(),
                        randomScalingFactor()

                    ],
                    backgroundColor: [
                        "#949FB1",
                        "#FFFFFF"
                    ],
                    labels: ['Temperature']
                }],
        },
        options: {
            responsive: true,
            legend: {
                display: false,
            },
            tooltips: {
                callbacks: {
                    label: function (tooltipItem, data) {
                        var dataset = data.datasets[tooltipItem.datasetIndex];
                        var index = tooltipItem.index;
                        return dataset.labels[index] + ': ' + dataset.data[index];
                    }
                }
            }

        }
    };

    var ctx2 = document.getElementById("erpiCity");
    var erpiCity = new Chart(ctx2, config);

</script>

