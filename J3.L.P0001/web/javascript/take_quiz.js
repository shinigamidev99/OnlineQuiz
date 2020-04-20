var time;
var timeRemaing;
var numberQuestion;
var index = 0;
var indexCurrent;

function main() {
    time = document.getElementById('time');
    timeRemaing = parseInt(time.textContent);
    numberQuestion = parseInt(document.getElementById('numberQuestion').textContent);
    indexCurrent = document.getElementById('indexCurrent');
    document.getElementById('question' + index).classList.remove('hidden');
    indexCurrent.textContent = 'Question: ' + (index + 1) + '/';
}

function timeRemaining() {
    var minute = Math.floor(timeRemaing / 60);
    var seconds = timeRemaing % 60;
    time.textContent = format(minute) + ':' + format(seconds);
}

function start() {
    var myTime = setInterval(() => {
        timeRemaing--;
        timeRemaining();
        if (timeRemaing <= 0) {
            document.getElementById("takeQuizForm").submit();
            clearInterval(myTime);
        }
    }, 1000);
}

function nextQuestion() {
    current = document.getElementById('question' + index++);
    index = index > (numberQuestion - 1) ? 0 : index;
    next = document.getElementById('question' + index);

    current.classList.add('hidden');
    next.classList.remove('hidden');
    indexCurrent.textContent = 'Question: ' + (index + 1) + '/';
}

function format(number) {
    return number < 10 ? '0' + number.toString() : number.toString();
}

