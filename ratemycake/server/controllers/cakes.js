var mongoose = require('mongoose');
var cake = mongoose.model('cake');
var rate = mongoose.model('rate'); 

module.exports = {
    index: function(req, res) { //all
        cake.find ({})
        .then(data => {
             res.json({ message: "Success", data: data }) 
             console.log(data)
        })
        .catch(err => {
            console.log("n1"+err);
            res.json({ message: "Error", error: err });})
    },
    create: function(req, res) { //post cake
        const q = new cake({
            name: req.body.name,
            url: req.body.url,
        });
      q.save()
          .then(data => res.json({ message: "Success inserted", data: data }))
          .catch(err => {
              console.log("n2"+err);
              res.json({ message: "Error", error: err })
          });
    },
    show: function(req, res) { //retrive one
        cake.findOne({_id: req.params.id})
        .then(data =>{
            res.json(data)
        } )
        .catch(err => {
            console.log("n3"+err);
            res.json({ message: "Error", error: err })
        })
    },

    rate:function(req, res) { 
        const r = new rate ()
        r.rating=req.body.rating;
        r.comment=req.body.comment;
        r.save()
        .then(data =>{
            data1 = cake.updateOne({ _id: req.params.id_cake }, {$push: { rating: data } } )
            .then (data=> {
                res.json({ message: "succcessfully updateddd"  })
            })
            .catch(err => {
                console.log("n3"+err);
                res.json({ message: "Error1", error: err })
        })
    })
        .catch(err => {
            console.log("n3"+err);
            res.json({ message: "Error", error: err })
        })
        },
};