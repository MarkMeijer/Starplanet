# Starplanet
A 2D Platformer game made in Java

This is a project ment to show people how it's done to make a simple Terraria/Starbound-style game using Java.
Here are only code source.
You need to setup textures and other resources yourself.

Please note: This project is VERY new. Not everything may work correctly and flawless. Do NOT report any bugs if they are listed here or if they are obvious to see.
Thank you.

To run this project, you are required to get Eclipse Java EE IDE and Java SE 8.0.
To make textures:
  Make a 40 by 40 gridlist with each grid 32^2 pixels.
  The first x row contains 3 textures in this order: Dirt, Grass, Stone
  To make a character, go on x=0 and y=18. Character is 2 grids high. So make a 32^2+32^2 texture for that.
  Maximal amount of textures on this gridlist is 1600.
  If you wish to expand it, just add more grids without changing the grid size, as every texture NEEDS to be 32x32 pixels in order to      work correctly according to the coding.
