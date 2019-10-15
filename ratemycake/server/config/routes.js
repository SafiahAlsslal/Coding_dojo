const mongoose = require('mongoose')
var mod = require('../controllers/cakes.js')

module.exports = function(app){
    app.get('/cakes', (req, res) => { 
        mod.index(req, res);
    });
    
    app.post('/cake',(req, res) => {
        mod.create(req, res)
    })

    app.post('/rate/:id_cake',(req, res) => {
        mod.rate(req, res)
    })
    
    app.get('/cakes/:id', (req, res) => {
        mod.show(req, res);
    })
}