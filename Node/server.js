var express    = require("express");
var mysql      = require('mysql');
var bodyParser = require('body-parser');


    var connection     =    mysql.createPool({
        connectionLimit : 100,
        waitForConnections : true,
        queueLimit :0,
        host     : 'professorsalary.cedagkwdo3ry.us-west-2.rds.amazonaws.com',
        user     : 'TBNF',
        password : 'mhetarwhite',
        database : 'HTP',
        debug    :  true,
        wait_timeout : 28800,
        connect_timeout :10
    });


var app = express();
var server = require('http').Server(app);
var io = require('socket.io')(server);
server.listen(3000);



app.set('view engine', 'ejs');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));



app.get("/home", function(req,res) {

});

app.get("/", function(req,res){
	res.send("Welcome to the Hokie Talent Pool");
});


io.on('connection', function (socket) {

  socket.emit('news', { incident:  "false" });
  socket.on('my other event', function (data) {
    console.log(data);
  });

});

app.get("/User",function(req,res){
connection.query('SELECT * from User', function(err, rows, fields) {
  if (!err)
    res.send(rows);
  else
    console.log('Error while performing Query.');
  });
});


app.get("/manage/Events", function(req, res) {
  connection.query('SELECT * from Event', function(err, rows, fields) {
  if (!err) {
    res.render('event_view', {info: rows, test: "hello"});
  }
  else
    console.log('Error while performing Query.');
  });


});

var doThisFunction = function(check) {
 io.on('connection', function (socket) {


	  socket.emit('news', { incident:  "true" });
	  socket.on('my other event', function (data) {
	    console.log(data);
	  });
 
});

};

app.get("/Zone",function(req,res){
connection.query('SELECT * from Zone', function(err, rows, fields) {
  if (!err)
    res.send(rows);
  else
    console.log('Error while performing Query.');
  });
});

app.post("/Zone", function(req, res){
	console.log(req.query);
	connection.query('INSERT INTO `Zone` (`id`, `signal_str`) VALUES ( "'+ req.body.id + '", "'+ req.body.signal_str+ '" )', function(err, rows, fields) {
	if(!err) { 
		res.send("Congrats son! Its IN!");
	}
	else
		res.send(err);
	});
});



app.post("/Event", function(req, res){
	console.log(req.query);
	connection.query('INSERT INTO `User` (`acceleration`, `heart_rate`, `location`, `resolved`, `user_id`) VALUES ( "'+ req.body.acceleration + '", "'+ req.body.heart_rate+'", "'+ req.body.location+'", "'+ req.body.resolved+'", "'+ req.body.user_id + '" )', function(err, rows, fields) {
	if(!err) { 
		if(req.body.resolved == 1) {
			io.sockets.emit('news', { incident:  "true", message:  "Incident has been resolved!" });
		}
		else {
			connection.query('SELECT * from User where `id` = ' + req.body.user_id , function(err, rows, fields) {
			  if (!err) {
			  	var output = rows[0].first_name + " " + rows[0].last_name + " is reporting an incident from " + rows[0].address + ". \n";
			    io.sockets.emit('news', { incident:  "true", test: calcStrong(), message: output});
			  } 
			  else
			    console.log('Error while performing Query.');
			  });
		}



		res.send("Congrats son! Its IN!");
	}
	else
		res.send(err);
	});
});







//app.listen(3000);