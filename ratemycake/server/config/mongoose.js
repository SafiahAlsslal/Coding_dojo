const mongoose = require('mongoose');
module.exports = {
   connect: mongoose.connect('mongodb://localhost/cake_db', {useNewUrlParser: true})
}

