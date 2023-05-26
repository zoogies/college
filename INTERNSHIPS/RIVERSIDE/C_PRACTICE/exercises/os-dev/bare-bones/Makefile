all:
	export PREFIX="$HOME/opt/cross"
	export TARGET=i686-elf
	export PATH="$PREFIX/bin:$PATH"
	export PATH="$HOME/opt/cross/bin:$PATH"
	
	mkdir build
	mkdir build/isodir
	mkdir build/isodir/boot
	mkdir build/isodir/boot/grub

	$TARGET-as boot.s -o ./build/boot.o
	$TARGET-gcc -c kernel.c -o ./build/kernel.o -std=gnu99 -ffreestanding -O2 -Wall -Wextra
	$TARGET-gcc -T linker.ld -o ./build/isodir/boot/myos.bin -ffreestanding -O2 -nostdlib ./build/boot.o ./build/kernel.o -lgcc

iso:
	grub-mkrescue -o ./build/myos.iso ./build/isodir

clean:
	rm -rf build