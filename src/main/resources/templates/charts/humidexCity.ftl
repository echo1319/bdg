<script>
    var color = "red";
    var quality = "Καλή";
    var humidex = 40;
    var max_humidex = 55;


    Chart.plugins.register({
        beforeDraw: function (chart) {
            var data = chart.data.datasets[0].data;

            var width = chart.chart.width,
                    height = chart.chart.height,
                    ctx = chart.chart.ctx;

            ctx.restore();

            var fontSize = (height / 10).toFixed(2);
            ctx.font = fontSize + "px Arial";
            ctx.textBaseline = "middle";

            var text = quality,
                    textX = Math.round((width - ctx.measureText(text).width) / 2),
                    textY = height / 2;

            ctx.fillText(text, textX, textY);
            ctx.save();
        }
    });

    var config = {
        type: 'doughnut',
        data: {
            labels: ["Humidex"],
            datasets: [
                {
                    data: [
                        humidex,
                        max_humidex - humidex
                    ],
                    backgroundColor: [
                        color,
                        "#FFFFFF"
                    ],
                    labels: ['Humidex']
                }
            ],
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
                        return dataset.labels[index] + ': ' + humidex;
                    }
                }
            }

        }
    };


    var ctx = document.getElementById("humidexCity");
    var humidexCity = new Chart(ctx, config);

</script>
