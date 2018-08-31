var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var port =  1234;

app.get('/', function(req, res){
  res.sendFile(__dirname + '/index.html');
});

app.get('/fern', function(req, res){
  res.sendFile(__dirname + '/remote.html');
});

app.get('/remote', function(req, res){
  res.sendFile(__dirname + '/remote.html');
});

io.on('connection', function(socket){
  socket.on('fernbedienung', function(msg)
  {
    //msg = msg.split("#§#")[1];
    console.log(msg);
    io.emit('change', msg);
  });

});

http.listen(port, function(){
  console.log('listening on *:' + port);
});
