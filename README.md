# Proxy Command

A command that allows to send commands from you minecraft server instances to a velocity proxy.


## Installation

To install this mod on fabric minecraft servers these requirements must be met:
* **fabric** and **[fabric API](https://modrinth.com/mod/fabric-api)** is installed on your minecraft servers
* **[FabricProxy-Lite](https://modrinth.com/mod/fabricproxy-lite)** is installed and working on you minecraft servers
* You have a velocity server up and running
* You must install both the fabric mod and the velocity plugin

Both the fabric mod and the velocity plugin are available on [modrinth](https://modrinth.com/mod/proxy-command-reloaded) with slug `proxy-command-reloaded`

The project source is available on [github/GeraldTM](https://github.com/GeraldTM/MCProxyCommand) with the latest
readme [here](https://github.com/GeraldTM/MCProxyCommand/blob/master/README.md).


## Usage instructions

On minecraft server instances the command `proxycommand "[command]"` can get used via command blocks or other
command sources, where a player is the source. The player must be a source of the command, since the plugin and
velocity needs this to handle the context of the command execution and send e.g. error messages back to
the player.

For example, you can teleport all players to a different server with a command block using
```
execute as @a run proxycommand "server SERVERNAME"
```




## Changelog

Changelog per release cycle can be found [here](https://github.com/GeraldTM/MCProxyCommand/blob/master/CHANGELOG.md).
This changelog contains information from one release to the next one.


## License

[MIT License](https://github.com/GeraldTM/MCProxyCommand/blob/master/LICENSE)


## Additional reading (for devs)

* [Fabric wiki](https://fabricmc.net/wiki/start)
* [Multiloader template](https://github.com/jaredlll08/MultiLoader-Template)

