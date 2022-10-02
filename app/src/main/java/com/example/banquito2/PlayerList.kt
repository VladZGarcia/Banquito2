package com.example.banquito2

class PlayerList() {

     val players = mutableListOf<Players>()
    private val usedPlayers = mutableListOf<Players>()


    init {

        createPlayers()

    }
    fun RndPlayer() : Players {

            if (players.size == usedPlayers.size) {
                usedPlayers.clear()
            }

            var player : Players? = null

            do {
                val rnd = (0 until players.size).random()
                player = players[rnd]
            } while(usedPlayers.contains(player))

            usedPlayers.add(player!!)

            return player

    }

    fun createPlayers() {

        val player2 = Players("Victor ", 100, false)
        players.add(player2)
        val player3 = Players("Jessica ", 100, false)
        players.add(player3)
        val player4 = Players("Lionel ", 100, false)
        players.add(player4)
        val player5 = Players("Andrea ", 100, false)
        players.add(player5)
    }
}