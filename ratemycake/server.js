const express = require("express");
const app = express();
const mongoose = require('mongoose');
const bodyParser = require("body-parser")
app.use(bodyParser.json())
app.use(express.static( __dirname + '/public/dist/public' ));
require('./server/config/mongoose.js')
require('./server/models/cake.js')
const session = require('express-session');
mongoose.Promise = global.Promise;
app.use(session({
  secret: 'keyboardkitteh',
  resave: false,
  saveUninitialized: true,
  cookie: { maxAge: 60000 }
}))
app.use(express.json());
const flash = require('express-flash');
app.use(flash());
app.set('view engine', 'ejs');
app.set('views', __dirname + '/client/views');
const server = app.listen(8000);
app.use(bodyParser.urlencoded({ extended: true}))
require('./server/config/routes.js')(app)
