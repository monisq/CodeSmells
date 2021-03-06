package com.directi.training.codesmells_refactored.duplicatecode.acrossclasses;

import com.directi.training.codesmells.duplicatecode.acrossclasses.AddEmployeeCmd;

import org.junit.Test;

import java.io.OutputStream;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddEmployeeCmdTest
{
    @Test
    public void testWrite() throws Exception
    {
        String name = "Smith";
        String address = "DirectI Plex";
        String city = "Mumbai";
        String state = "Maharashtra";
        String annualSalary = "10000000";
        com.directi.training.codesmells.duplicatecode.acrossclasses.AddEmployeeCmd addEmployeeCmd = new com.directi.training.codesmells.duplicatecode.acrossclasses.AddEmployeeCmd(name, address, city, state,
            annualSalary);
        OutputStream outputStream = mock(OutputStream.class);
        addEmployeeCmd.write(outputStream);
        verify(outputStream).write(
            com.directi.training.codesmells.duplicatecode.acrossclasses.AddEmployeeCmd.header);
        verify(outputStream).write(53);
        verify(outputStream).write(
            com.directi.training.codesmells.duplicatecode.acrossclasses.AddEmployeeCmd.commandChar);
        verify(outputStream).write(name.getBytes());
        verify(outputStream, atLeastOnce()).write(0x00);
        verify(outputStream).write(address.getBytes());
        verify(outputStream, atLeastOnce()).write(0x00);
        verify(outputStream).write(city.getBytes());
        verify(outputStream, atLeastOnce()).write(0x00);
        verify(outputStream).write(state.getBytes());
        verify(outputStream, atLeastOnce()).write(0x00);
        verify(outputStream).write(annualSalary.getBytes());
        verify(outputStream, atLeastOnce()).write(0x00);
        verify(outputStream).write(AddEmployeeCmd.footer);
    }
}
