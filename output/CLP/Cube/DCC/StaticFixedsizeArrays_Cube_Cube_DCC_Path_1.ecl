:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Cube_Cube_DCC_Path_1(Self,InputArray):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [2, 2, 2],
InputArray_dimensionSizes = [2, 2, 2],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(InputArray,InputArray_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
(Self_data = InputArray),

%TypeVar Labeling Parts
labeling_Arrays([InputArray]).
