package iguanaman.hungeroverhaul.api;

interface IFoodValueModifier
{
    /**
     * The lower the returned value, the earlier this will be called
     * in relation to the other registered modifiers
     * 
     * For example, if there is a food modifier with priority -1 and another with priority 0,
     * the one with priority -1 will be applied before the one with priority 0
     */
    public int getPriority();
}
