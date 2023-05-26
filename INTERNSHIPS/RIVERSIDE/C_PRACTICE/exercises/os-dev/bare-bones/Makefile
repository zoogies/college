PREFIX := $(HOME)/opt/cross
TARGET := i686-elf
CC := $(TARGET)-gcc
AS := $(TARGET)-as
ISO := build/myos.iso

# Set the PATH variable
export PATH := $(PREFIX)/bin:$(PATH)
export PATH := $(HOME)/opt/cross/bin:$(PATH)

# Default target
all: $(ISO)

# Compile assembly file
build/boot.o: boot.s
	$(AS) $< -o $@

# Compile C file
build/kernel.o: kernel.c
	$(CC) -c $< -o $@ -std=gnu99 -ffreestanding -O2 -Wall -Wextra

# Link object files to create the final binary
isodir/boot/myos.bin: build/boot.o build/kernel.o
	$(CC) -T linker.ld -o $@ -ffreestanding -O2 -nostdlib $^ -lgcc

# Create ISO image using GRUB
$(ISO): isodir/boot/myos.bin
	grub-mkrescue -o $@ isodir

# Clean build directory
clean:
	rm -rf build/*

# PHONY targets
.PHONY: all clean
