Alien Treaty
===========

This is an example of building extensible Java applications using the Service Provider Interface.

Service Provider: Defines the SPI specification for export service. It has the overloaded export method that defines the behaviour of exporting data into particular formats.

Service Provider Implementation: Provides the implementation logic for the Export SPI. It maintains two different collections: one for exporting data into plain text and the other into pdf.

A new export format can be added without making any changes to the existing API. This new class should implement the Service Provider interface and should be registered in META-INF/services.
