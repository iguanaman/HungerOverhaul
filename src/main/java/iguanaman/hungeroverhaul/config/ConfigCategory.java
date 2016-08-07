package iguanaman.hungeroverhaul.config;

import net.minecraftforge.common.config.Configuration;

public class ConfigCategory
{
    String name;
    String comment;

    public ConfigCategory(String name, String comment)
    {
        this.name = name;
        this.comment = comment;
    }

    public net.minecraftforge.common.config.ConfigCategory get(Configuration config)
    {
        return config.getCategory(name);
    }

    public void create(Configuration config)
    {
        net.minecraftforge.common.config.ConfigCategory category = get(config);
        category.setComment(comment);
    }

    public void remove(Configuration config)
    {
        if (get(config) != null)
            config.removeCategory(get(config));
    }
}
