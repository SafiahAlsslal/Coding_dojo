var mongoose = require('mongoose');

const RateSchema = new mongoose.Schema({
   rating: {type: Number,required:true},
   comment: {type: String,required: true}
}, { timestamps: true });


const CakeSchema = new mongoose.Schema({
   name: { type: String, required: true, minlength: 3},
   url: {type: String ,required: true },
   rating: [RateSchema]
     },
       {timestamps: true });

module.exports = {
   rate : mongoose.model('rate', RateSchema),
   cake : mongoose.model('cake', CakeSchema)
}