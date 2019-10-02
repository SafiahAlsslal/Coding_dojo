class card {
    constructor (suit,value,num){ 
       this.suit=suit
       this.str=value
       this.num=num
    } 

    show () {
        console.log('card:'+ this.suit +this.str +this.num)
    }
}

class Deck {
    constructor () {
        this.deck = [];
        this.suits = ['Hearts', 'Spades', 'Clubs', 'Diamonds'];
        this.str = ['Ace', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine', 'ten', 'Jack', 'Queen', 'King'];
        this.num= [ 1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10 , 11 , 12, 13 ]
    }
    getDeck()
    {
        for(var i = 0; i < this.suits.length; i++)
        {
            for(var x = 0; x < this.str.length; x++)
            {
                var card = {Str: this.str[x], Num:this.num[x] , Suit: this.suits[i]};
                this.deck.push(card);
            }
        }
    }

    shuffle()
    {
	for (var i = 0; i < 1000; i++)
	{
		var po1 = Math.floor((Math.random() * this.deck.length));
		var po2 = Math.floor((Math.random() * this.deck.length));
		var tmp = this.deck[po1];
		this.deck[po1] = this.deck[po2];
        this.deck[po2] = tmp;
    }
}
    reset () {
        deck=[]
        return this.getDeck ();
    }

     deal () {
        return this.deck.pop()
    }

    }

    class Player {
        constructor (name,deck) {
            this.name=name
            this.deck = deck
            this.new_arr =[]
        }
        hand () {
            for (var i=0 ; i<7 ; i++) {
                this.new_arr.push(this.deck.deal())
            }
            return this.new_arr;
        }
        takeacard() {
            return this.deck.deal()
        }

        discardcard (num) {
            this.new_arr.splice(num,1)
            return this.new_arr
        }
    }

    const deck1 = new Deck();
    deck1.getDeck()
    deck1.shuffle()
    const player1= new Player ('SAFIAH',deck1);
    console.log (player1.hand())
    console.log (player1.takeacard())
    console.log (player1.discardcard(2))
    
    
    
