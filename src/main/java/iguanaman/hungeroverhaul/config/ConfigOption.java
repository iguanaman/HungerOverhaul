package iguanaman.hungeroverhaul.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigOption<T>
{
    public String category;
    public String name;
    public T defaultValue;
    public T blankSlate;
    public String comment;
    public T minValue;
    public T maxValue;

    public ConfigOption(String category, String name, T defaultValue, T blankSlate, String comment)
    {
        this(category, name, defaultValue, null, null, blankSlate, comment);
    }

    public ConfigOption(String category, String name, T defaultValue, T minValue, T maxValue, T blankSlate, String comment)
    {
        this.category = category;
        this.name = name;
        this.defaultValue = defaultValue;
        this.blankSlate = blankSlate;
        this.comment = comment;
        this.minValue = minValue != null ? minValue : getDefaultMinValue();
        this.maxValue = maxValue != null ? maxValue : getDefaultMaxValue();
    }

    public String getComment()
    {
        String commentSuffix = "vanilla: " + blankSlate;
        return comment + " [" + commentSuffix + "]";
    }

    @SuppressWarnings("unchecked")
    private T getDefaultMinValue()
    {
        if (defaultValue instanceof Integer)
            return (T) Integer.valueOf(Integer.MIN_VALUE);
        else if (defaultValue instanceof Float)
            return (T) Float.valueOf(-Float.MAX_VALUE);
        else if (defaultValue instanceof Double)
            return (T) Double.valueOf(-Double.MAX_VALUE);
        else
            return null;
    }

    @SuppressWarnings("unchecked")
    private T getDefaultMaxValue()
    {
        if (defaultValue instanceof Integer)
            return (T) Integer.valueOf(Integer.MAX_VALUE);
        else if (defaultValue instanceof Float)
            return (T) Float.valueOf(Float.MAX_VALUE);
        else if (defaultValue instanceof Double)
            return (T) Double.valueOf(Double.MAX_VALUE);
        else
            return null;
    }

    @SuppressWarnings("unchecked")
    public T get(Configuration config)
    {
        if (defaultValue instanceof Boolean)
            return (T) Boolean.valueOf(config.getBoolean(name, category, (Boolean) defaultValue, getComment()));
        else if (defaultValue instanceof Integer)
            return (T) Integer.valueOf(config.getInt(name, category, (Integer) defaultValue, (Integer) minValue, (Integer) maxValue, getComment()));
        else if (defaultValue instanceof Float)
            return (T) Float.valueOf((float) config.getFloat(name, category, (Float) defaultValue, (Float) minValue, (Float) maxValue, getComment()));
        else if (defaultValue instanceof Double)
            return (T) Double.valueOf(Math.min((Double) maxValue, Math.max((Double) minValue, getProperty(config).getDouble())));
        else if (defaultValue instanceof String)
            return (T) config.getString(name, category, (String) defaultValue, getComment());
        else
            throw new RuntimeException("Unknown ConfigOption type for '" + category + ":" + name + "': " + defaultValue.getClass().getName());
    }

    public T getBackwardsCompatible(Configuration config, ConfigOption<T> legacyConfigOption)
    {
        if (!this.exists(config) && legacyConfigOption.exists(config))
        {
            T oldConfigOptionValue = legacyConfigOption.get(config);
            if (oldConfigOptionValue != null)
                set(config, oldConfigOptionValue);
        }
        return get(config);
    }

    public Property getProperty(Configuration config)
    {
        Property property = config.getCategory(category).get(name);
        if (property == null)
            property = config.get(category, name, defaultValue.toString());
        return property;
    }

    public boolean exists(Configuration config)
    {
        return config.hasCategory(category) && config.getCategory(category).containsKey(name);
    }

    public void set(Configuration config, T value)
    {
        Property property = getProperty(config);
        if (value instanceof Boolean)
            property.set((Boolean) value);
        else if (value instanceof Integer)
            property.set((Integer) value);
        else if (value instanceof Float)
            property.set((Float) value);
        else if (value instanceof Double)
            property.set((Double) value);
        else if (value instanceof String)
            property.set((String) value);
        else
            throw new RuntimeException("Unknown ConfigOption type for '" + category + ":" + name + "': " + defaultValue.getClass().getName());
    }

    public void setToBlankSlate(Configuration config)
    {
        get(config);
        set(config, blankSlate);
    }

    public void setToDefault(Configuration config)
    {
        get(config);
        set(config, defaultValue);
    }

    public void remove(Configuration config)
    {
        config.getCategory(category).remove(name);
    }
}
