const express = require("express");
const app = express();
const bodyParser = require("body-parser")
app.use(bodyParser.json())
app.use(express.static( __dirname + '/public/dist/public' ));
// const session = require('express-session');
// app.use(session({
//   secret: 'keyboardkitteh',
//   resave: false,
//   saveUninitialized: true,
//   cookie: { maxAge: 60000 }
// }))
app.use(express.json());
const server = app.listen(8000);
app.use(bodyParser.urlencoded({ extended: true}))
app.all("*", (req,res,next) => {
  res.sendFile(path.resolve("./public/dist/public/index.html"))
});

