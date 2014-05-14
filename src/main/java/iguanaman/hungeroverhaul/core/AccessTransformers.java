package iguanaman.hungeroverhaul.core;

import java.io.IOException;

import cpw.mods.fml.common.asm.transformers.AccessTransformer;

public class AccessTransformers extends AccessTransformer
{
    public AccessTransformers() throws IOException
    {
        super("HungerOverhaul_at.cfg");
    }
}